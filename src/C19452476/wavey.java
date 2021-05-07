package C19452476;
import ie.tudublin.Visual;
import processing.core.PApplet;



public class wavey
{
    private static Visual mv;
    private static float cy;



    public wavey(MaxVisual mv)
    {
       this.mv = mv;
       cy = this.mv.height / 2;
    }

    public wavey() {
        
    }

    public static void render()
    {
        mv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                    PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 225)
                    , 255
                    , 255
            );

            mv.line(i, cy, i, cy + cy * mv.getAudioBuffer().get(i));
        }

    }




}
