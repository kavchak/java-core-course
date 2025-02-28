package javaCourse.classwork.lesson12;

import java.util.ArrayList;
import java.util.List;

public class DefaultInterface {

    public static void main(String[] args) {
        List<RemoteControllable> remotes = new ArrayList<>();

        remotes.add(new RemoteControlTV());
        remotes.add(new RemoteControlRadio());

       for (RemoteControllable remote: remotes) {
           remote.turnOn();
           remote.switchChannel();
           remote.switchVolume();
       }
    }

    public interface RemoteControllable {
        default void turnOn() {
            System.out.println("turn on");
        }

        void switchChannel();

        void switchVolume();
    }

    public static class RemoteControlTV implements RemoteControllable {

        @Override
        public void turnOn() {
            System.out.println("натискаємо кнопку вкл");
        }

        @Override
        public void switchChannel() {
            System.out.println("натискаємо вверх вниз");
        }

        @Override
        public void switchVolume() {
            System.out.println("натискаємо вверх вниз");
        }
    }

    public static class RemoteControlRadio implements  RemoteControllable {

        @Override
        public void switchChannel() {
            System.out.println("крутимо ручку");
        }

        @Override
        public void switchVolume() {
            System.out.println("крутимо ручку");
        }
    }
}
