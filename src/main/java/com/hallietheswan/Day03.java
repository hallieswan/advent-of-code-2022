package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day03 implements Day {

    private List<String> inventory;

    public Day03(String fileName) throws URISyntaxException, IOException {
        inventory = Utility.readFileLinesFromResources(fileName);
    }

    // Input - list of all items currently in each rucksack
    // Each char = a type of item, single lowercase or uppercase letter (e.g. a and A are different types)
    // Each line = list of items for one rucksack
    // Each rucksack has equal item count in each compartment
    // ...first compartment = first half of characters in line
    // ...second compartment = second half of characters in line
    // Each rucksack can contain a different total number of items
    // ...i.e. "half" is determined per line
    // Per rucksack, there will be exactly one item type that is shared between compartments
    private char getDuplicatedItemType(String str) {
        int totalItems = str.length();

        // identify all items in left compartment
        Set<Character> left = new HashSet();
        for (int i = 0; i < totalItems / 2; i++) {
            left.add(str.charAt(i));
        }

        // identify item type that is also in right compartment
        for (int i = totalItems / 2; i < totalItems; i++) {
            if (left.contains(str.charAt(i))) return str.charAt(i);
        }

        // no overlapping item found
        return '0';
    }

    // Every item type can be converted to a priority
    // ...Lowercase item types a through z have priorities 1 through 26
    // ...Uppercase item types A through Z have priorities 27 through 52
    private int getItemTypePriority(char c) {
        return c >= 'a' ? c - 'a' + 1 : c - 'A' + 27;
    }

    @Override
    public int part1() {
        int totalPriority = 0;
        for (String str : inventory) {
            char c = getDuplicatedItemType(str);
            totalPriority += getItemTypePriority(c);
        }
        return totalPriority;
    }

    private char getGroupBadge(List<String> group) {
        // add first rucksack
        Set<Character> set = new HashSet<>();
        set = getItemTypeSet(group.get(0));

        // compare each subsequent rucksack
        for (String bag : group.subList(1, group.size())) {
            Set<Character> thisSet = getItemTypeSet(bag);
            set.retainAll(thisSet);
        }

        // return the item type
        return set.stream().findFirst().orElse('0');
    }

    private Set<Character> getItemTypeSet(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    @Override
    public int part2() {
        int groupSize = 3;
        int groups = inventory.size() / groupSize;
        int totalPriority = 0;
        for (int i = 0, left = 0; i < groups; i++, left += groupSize) {
            char c = getGroupBadge(inventory.subList(left, left + groupSize));
            totalPriority += getItemTypePriority(c);
        }
        return totalPriority;
    }
}
