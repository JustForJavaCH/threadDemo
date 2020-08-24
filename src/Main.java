import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Double> bagWeightList = new ArrayList<>();
        while (in.hasNext()) {
            String bagWeightStr = in.next();
            String[] bagWeights = bagWeightStr.split("\\,");
            for (String weight : bagWeights) {
                bagWeightList.add(Double.parseDouble(weight));
            }
            Collections.sort(bagWeightList);
            double sumWeight = 0;
            double maxLoad = Double.valueOf(in.next());
            if (maxLoad >= 50000.0) {
                maxLoad = 50000.0;
            }
            if (bagWeightList.size() > 1000) {
                bagWeightList = bagWeightList.subList(0, 1000);
            }
            for (int i = 1, bagCount = bagWeightList.size(); i <= bagCount; i++) {
                sumWeight += bagWeightList.get(i - 1);
                if (sumWeight > maxLoad) {
                    System.out.println(i-1);
                } else if (sumWeight < maxLoad) {
                    if (i >= bagWeightList.size()) {
                        System.out.println(i);
                        break;
                    } else {
                        continue;
                    }
                } else {
                    if (i <= bagWeightList.size()) {
                        System.out.println(i);
                    } else {
                        System.out.println(i);
                    }
                }

            }

        }
    }
}

