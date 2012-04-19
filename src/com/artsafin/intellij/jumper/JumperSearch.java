package com.artsafin.intellij.jumper;

import java.util.List;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class JumperSearch
{
    /**
     * Searches next character in sequence, that are present in the list of accepted chars
     *
     * @param startFrom Start search from this position in seq
     * @param seq Character sequence to search in
     * @param acceptedChars A list of accepted chars
     * @return Position of found character or -1 if not found
     */
    public int nextChar(final int startFrom, final CharSequence seq, final List<Character> acceptedChars)
    {
        boolean found = false;
        int pos = startFrom,
                length = seq.length();

        while (++pos < length)
        {
            if (acceptedChars.contains(seq.charAt(pos)))
            {
                found = true;
                break;
            }
        }

        return found?pos:-1;
    }

    public int prevChar(final int startFrom, final CharSequence seq, final List<Character> acceptedChars)
    {
        boolean found = false;
        int pos = startFrom;

        while (--pos >= 0)
        {
            if (acceptedChars.contains(seq.charAt(pos)))
            {
                found = true;
                break;
            }
        }

        return found?pos:-1;
    }
}
