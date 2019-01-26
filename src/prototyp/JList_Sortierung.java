package prototyp;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class JList_Sortierung {
    static class Entity {
        private final String name;
        private final double price;
        private final LocalDate localDate;
        private final Date date;

        public Entity(String name, double price, LocalDate localDate, Date date) {
            this.name = name;
            this.price = price;
            this.localDate = localDate;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public Date getDate() {
            return date;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate _2014 = LocalDate.of(2014, 1, 2);
        LocalDate _2013 = LocalDate.of(2013, 1, 2);

        Entity test1 = new Entity("Sepp Brösl", 100.4, now, Date.from(now.atStartOfDay().toInstant(ZoneOffset.UTC)));
        Entity test2 = new Entity("Donald Duck", 44.59, _2014, Date.from(_2014.atStartOfDay().toInstant(ZoneOffset.UTC)));
        Entity test3 = new Entity("Micky Maus", 155.33, _2013, Date.from(_2013.atStartOfDay().toInstant(ZoneOffset.UTC)));

        List<Entity> liste = new ArrayList<>();
        liste.add(test1);
        liste.add(test2);
        liste.add(test3);

        // JList erstellen aus vorhandener Liste
        JList<Entity> uiList = new JList<>(new AbstractListModel<Entity>() {
            public int getSize() { return liste.size(); }
            public Entity getElementAt(int i) { return liste.get(i); }
        });

        System.out.println(liste); // unsortiert

        liste.sort(Comparator.comparing(Entity::getName));
        System.out.println("nach name: " + liste); // nach name

        liste.sort(Comparator.comparingDouble(Entity::getPrice));
        System.out.println("nach preis: " + liste); // nach preis

        liste.sort(Comparator.comparing(Entity::getDate));
        System.out.println("nach date: " + liste); // nach date

        liste.sort(Comparator.comparing(Entity::getLocalDate));
        System.out.println("nach localdate: " + liste); // nach localdate
    }
}