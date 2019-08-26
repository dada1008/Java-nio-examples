import java.nio.ByteBuffer;

public class ByteBufferTest {

    public static void main(String[] args) {

        //Create a directBuffer of size 200 bytes
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(200);

        //Create a nonDirectBuffer of size 200 bytes
        ByteBuffer nonDirectBuffer = ByteBuffer.allocate(200);

        //Get the capacity of the buffer
        System.out.println("Capacity "+nonDirectBuffer.capacity());

        //Get the position of the buffer
        System.out.println("Position "+nonDirectBuffer.position() );

        //Add data of different types to the buffer
        nonDirectBuffer.putChar('A');
        nonDirectBuffer.putInt(10);
        nonDirectBuffer.putDouble(0.98);

        //Get the position of the buffer, would print 14 as its has 14 bytes of data
        System.out.println("Position "+nonDirectBuffer.position() );
        nonDirectBuffer.putFloat(8.9f);

        //Fetch the data from buffer
        System.out.println(nonDirectBuffer.getChar(0));

        //A char is of 2 bytes, so fetch the integer at index 0+2=2bytes
        System.out.println(nonDirectBuffer.getInt(2));

        //A int is of 4 bytes so fetch the double value at index 2+4=6bytes
        System.out.println(nonDirectBuffer.getDouble(6));

        //A double is of 8 bytes so fetch the float value at index 6+8=14bytes
        System.out.println(nonDirectBuffer.getFloat(14));

    }
}