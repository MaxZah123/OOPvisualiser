package C19452476;

import ie.tudublin.*;

public class MaxVisual extends Visual {


    public void settings() {
        size(1080, 800, P3D);
    }

    public int chosen = 1;
    cube cubea;
    Loops loopsa;
    //wavey waveya;

    public void setup() {
        surface.setResizable(true);
        background(0);
        startMinim();
        loadAudio("heroplanet.mp3");

        cubea = new cube(this);
        loopsa = new Loops(this);
        //waveya = new wavey(this);

        getAudioPlayer().play();
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

           new Loops();
           new cube();
            //new wavey();

        }
    }


    public void draw()
    {
       // background(70);
        try
        {
            calculateFFT();             // Call this if you want to use FFT data
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();      // Call this is you want to use frequency bands
        calculateAverageAmplitude();    // Call this is you want to get the average amplitude


        loopsa.render();
        cubea.render();
        //wavey.render();
    }

    @Override
    public void stroke() {

    }
}






