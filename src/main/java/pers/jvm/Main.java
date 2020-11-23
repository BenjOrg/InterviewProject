package pers.jvm;

public class Main {

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.getFood().say();

        Bird guguBird = new GuguBird();
        guguBird.getFood().say();

        GuguBird realGuguBird = new GuguBird();
        realGuguBird.getFood().say();
    }
}
