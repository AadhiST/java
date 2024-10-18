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
        System.out.println("Drawing circle");

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