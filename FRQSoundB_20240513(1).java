import java.util.Arrays;

public class Sound
{
    /** the array of values in this sound; guaranteed not to be null */
    private int[] samples =
    {
        0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0
    };

    /**
     * Removes all silence from the beginning of this sound. Silence is represented
     * by a value of 0. Precondition: samples contains at least one nonzero value
     * Postcondition: the length of samples reflects the removal of starting
     * silence
     */
    public void trimSilenceFromBeginning()
    {
        int counter = 0;
        boolean status = false;
        for(int sample : samples){
            if (sample != 0){
               break; 
            }
            counter++;
        }
       int[] newSamples =  new int[(samples.length - counter)];
        
       for(int i = 0; i < newSamples.length; i++){
           newSamples[i] = samples[i+counter];
       }
        
        samples = new int[newSamples.length];
        
       for(int i = 0; i < newSamples.length; i++){
          samples[i] = newSamples[i]; 
       }

    }
        

    public static void main(String[] args)
    {

        Sound s = new Sound();

        System.out.println(
                "The original array of samples is " + Arrays.toString(s.samples));
        s.trimSilenceFromBeginning();
        System.out.println(
                "The new array of samples is " + Arrays.toString(s.samples));
        System.out.println(
                "The length of the new array should be 12 and is "
                        + s.samples.length);
    }
}

