package ru.nsu.fit.exercises;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class User {
    String name;
    Set<User> friends;
    public User(String name) {
        this.name = name;
        friends = new HashSet<>();
    }
    public void befriend(User other){
        friends.add(other);
        other.friends.add(this);
    }

    // является прямым другом
    public boolean isDirectFriendOf(User other){
        return friends.contains(other);
    }
    private boolean searchFriend(User user, User other, HashSet<User> visited){
        if(visited.contains(user))
            return false;
        visited.add(user);

        if(other.isDirectFriendOf(user))
            return true;
        for(User friend : user.friends){
            if(searchFriend(friend, other, visited))
                return true;
        }
        return false;
    }
    // является косвенным другом
    public boolean isIndirectFriendOf1(User other){
        HashSet<User> visited = new HashSet<>();
        return searchFriend(this, other, visited);
    }
    public boolean isIndirectFriendOf(User other) { // пример из книги
        Set<User> visited = new HashSet<>();
        Deque<User> frontier = new LinkedList<>();
        frontier.add(this);
        while (!frontier.isEmpty()) {
            User user = frontier.removeFirst();
            if (user.equals(other)) {
                return true;
            }
            if (visited.add(user)) { // Если узел не посещался
                frontier.addAll(user.friends); // addAll вставляет с конца
            }
        }
        return false;
    }
}
