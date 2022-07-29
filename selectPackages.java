public class test {
    public static void selectPackages(int truckSpace, List<Integer> packagesSpace) {
        HashMap<Integer, Integer> weightToIdx = new HashMap<>();
        int first = -1;
        int second = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < packagesSpace.size(); i++) {
            int complement = truckSpace - 30 - packagesSpace.get(i);
            if (weightToIdx.containsKey(complement)) {

                // return new pair(weightToIdx.get(complement), i);
                // ***
                // according to the 3rd assumption, we cant return the answer directly
                // even we found one pair
                // we need traverse all the pairs and select the pair with the largest package
                // For example, if the arrayList contains [15, 25, 35, 45] and truckSpace is 90
                // first we traverse arrayList, we see 15, 25, 35
                // then we found a pair [25, 35]
                // but we cant return [25, 35] directly, we have to finish check all pairs
                // then we see [45] and we found the 2nd pair [15, 45].
                // since [15, 45] contains the largest package in these two pairs
                // we return index of this pair

                // if we have 2 pairs of answer, one is [25, 35], and the other is [15, 45]
                // we will choose [15, 45] since 45 is the largest package in these two pairs
                // I was too nervous, but
                // if (max < packagesSpace.get(i) || max < complement)
                // we use hashmap.get(complement) to get its index (unique ID)
                // then use the index to find the space, which is exactly "complement"
                if (max < packagesSpace.get(i) || max < packagesSpace.get(weightToIdx.get(complement))) {
                    first = weightToIdx.get(complement);
                    second = i;
                    max = Math.max(packagesSpace.get(first), packagesSpace.get(second));
                }
            }
            weightToIdx.put(packagesSpace.get(i), i);
        }
        // return new pair(-1, -1);
        System.out.println(first);
        System.out.println(second);
    }
