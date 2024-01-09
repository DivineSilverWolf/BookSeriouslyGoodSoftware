package ru.nsu.fit.exercises;

public class TestUser {
    public static void main(String[] args) {
        User user = new User("John");
        User user2 = new User("Mary");
        User user3 = new User("Jorge");
        User user4 = new User("Jose");

        user.befriend(user2);
        user2.befriend(user3);
        user3.befriend(user4);

        System.out.println(user.isDirectFriendOf(user2));
        System.out.println(user.isIndirectFriendOf1(user4));
    }
}
