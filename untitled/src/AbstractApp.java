import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractApp {
    protected BufferedReader reader;

    public final static String INVALID_SELECTION = "Invalid Selection!";

    public AbstractApp(BufferedReader _reader)
    {
        this.reader = _reader;
    }

    protected String readFilename() throws IOException
    {
        String readLine = reader.readLine();
        return readLine;
    }

    protected int readPositiveNumber() throws IOException
    {
        String readLine = reader.readLine();
        int result = -1;

        try {
            result = Integer.valueOf(readLine);
        }
        catch (NumberFormatException e)
        {
            return result;
        }
