package com.hallietheswan.day07;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DirectoryNode {

    private String dirName;
    private DirectoryNode parent;
    private HashMap<String, DirectoryNode> childDirectoriesMap;
    private HashSet<String> files;
    private int thisDirFileSize;

    public DirectoryNode(String dirName) {
        this.dirName = dirName;
        childDirectoriesMap = new HashMap();
        files = new HashSet();
        thisDirFileSize = 0;
    }

    public DirectoryNode(String dirName, DirectoryNode parent) {
        this(dirName);
        this.parent = parent;
    }

    public boolean insertChildDirectory(String dirName) {
        boolean canInsert = !childDirectoriesMap.containsKey(dirName);
        if (canInsert) {
            childDirectoriesMap.put(
                    dirName,
                    new DirectoryNode(dirName, this)
            );
        }
        return canInsert;
    }

    public boolean insertFile(String fileName, int fileSize) {
        boolean canInsert = !files.contains(fileName);
        if (canInsert) {
            files.add(fileName);
            thisDirFileSize += fileSize;
        }
        return canInsert;
    }

    public DirectoryNode moveToChild(String dirName) {
        return childDirectoriesMap.getOrDefault(dirName, null);
    }

    public DirectoryNode moveToParent() {
        return parent;
    }

    public int getTotalFileSize() {
        int total = thisDirFileSize;
        for (DirectoryNode child : childDirectoriesMap.values()) {
            total += child.getTotalFileSize();
        }
        return total;
    }

    public int getThisDirFileSize() {
        return thisDirFileSize;
    }

    public String getDirName() {
        return dirName;
    }

    public Collection<DirectoryNode> getChildren() {
        return childDirectoriesMap.values();
    }
}
