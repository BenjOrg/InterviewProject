package pers.jvm;

public class GuguBird extends Bird {

    @Override
    public ButterFly getFood(){
        ButterFly butterFly = new ButterFly();
        butterFly.name = "butterfly";
        return butterFly;
    }
}
