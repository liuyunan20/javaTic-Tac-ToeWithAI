import java.util.*;

class AsciiCharSequence implements java.lang.CharSequence {
    private final byte[] sequence;
    AsciiCharSequence (byte[] sequence) {
        this.sequence = sequence;
    }

    public int length() {
        return sequence.length;
    }

    public char charAt(int idx) {
        return (char) sequence[idx];
    }

    public CharSequence subSequence(int from, int to) {
        return new AsciiCharSequence(Arrays.copyOfRange(sequence, from, to));
    }

    public String toString() {
        return new String(sequence);
    }
}