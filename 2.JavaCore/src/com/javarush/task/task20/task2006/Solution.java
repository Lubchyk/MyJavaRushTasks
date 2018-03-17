package com.javarush.task.task20.task2006;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* 
Как сериализовать?
*/
public class Solution {
    public static class Human implements Serializable {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Human)) return false;
            Human human = (Human) o;
            return Objects.equals(name, human.name) &&
                    Objects.equals(assets, human.assets);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, assets);
        }
    }

    public static void main(String[] args) {

    }
}
