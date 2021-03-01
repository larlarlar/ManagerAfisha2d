package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Afisha;

@AllArgsConstructor
@NoArgsConstructor

public class AfishaManager {
    private Afisha[] items = new Afisha[0];
    int movieCount = 10;

    public AfishaManager(int movieCount) {
        if (movieCount >= 0) {
            this.movieCount = movieCount;
        }
    }

    public Afisha[] getNewest() {
        int count;
        if (items.length > movieCount) {
            count = movieCount;
        } else {
            count = items.length;
        }

        Afisha[] result = new Afisha[count];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Afisha[] getItems() {
        return items;
    }

    public void add(Afisha item) {
        int length = items.length + 1;
        Afisha[] tmp = new Afisha[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }
}
