interface Drawable
{
    void draw();
}
/*class rectangle implements Drawable {
    public void draw()
    {
        System.out.println("Drawing rectangle");
    }
}*/
class circle implements Drawable{
    public void Draw()
    {
        System.out.println("Drawing a circle");

    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
class TestInterface
{
    public static void main(String args[])
    {
        Drawable d=new circle();
        d.draw();
    }
}