/* Generated By:JavaCC: Do not edit this line. ESFParserTokenManager.java */
package org.lwes.db;

public class ESFParserTokenManager implements ESFParserConstants {
    public java.io.PrintStream debugStream = System.out;

    public void setDebugStream(java.io.PrintStream ds) {
        debugStream = ds;
    }

    private final int jjStopStringLiteralDfa_0(int pos, long active0) {
        switch (pos) {
            default:
                return -1;
        }
    }

    private final int jjStartNfa_0(int pos, long active0) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
    }

    private final int jjStopAtPos(int pos, int kind) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        return pos + 1;
    }

    private final int jjStartNfaWithStates_0(int pos, int kind, int state) {
        jjmatchedKind = kind;
        jjmatchedPos = pos;
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return pos + 1;
        }
        return jjMoveNfa_0(state, pos + 1);
    }

    private final int jjMoveStringLiteralDfa0_0() {
        switch (curChar) {
            case 35:
                return jjStopAtPos(0, 5);
            case 59:
                return jjStopAtPos(0, 13);
            case 123:
                return jjStopAtPos(0, 11);
            case 125:
                return jjStopAtPos(0, 12);
            default:
                return jjMoveNfa_0(0, 0);
        }
    }

    private final void jjCheckNAdd(int state) {
        if (jjrounds[state] != jjround) {
            jjstateSet[jjnewStateCnt++] = state;
            jjrounds[state] = jjround;
        }
    }

    private final void jjAddStates(int start, int end) {
        do {
            jjstateSet[jjnewStateCnt++] = jjnextStates[start];
        } while (start++ != end);
    }

    private final void jjCheckNAddTwoStates(int state1, int state2) {
        jjCheckNAdd(state1);
        jjCheckNAdd(state2);
    }

    private final void jjCheckNAddStates(int start, int end) {
        do {
            jjCheckNAdd(jjnextStates[start]);
        } while (start++ != end);
    }

    private final void jjCheckNAddStates(int start) {
        jjCheckNAdd(jjnextStates[start]);
        jjCheckNAdd(jjnextStates[start + 1]);
    }

    private final int jjMoveNfa_0(int startState, int curPos) {
        int[] nextStates;
        int startsAt = 0;
        jjnewStateCnt = 1;
        int i = 1;
        jjstateSet[0] = startState;
        int j, kind = 0x7fffffff;
        for (; ;) {
            if (++jjround == 0x7fffffff) {
                reInitRounds();
            }
            if (curChar < 64) {
                long l = 1L << curChar;
                MatchLoop:
                do {
                    switch (jjstateSet[--i]) {
                        case 0:
                            if ((0x7ff000000000000L & l) == 0L) {
                                break;
                            }
                            kind = 10;
                            jjstateSet[jjnewStateCnt++] = 0;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            }
            else if (curChar < 128) {
                long l = 1L << (curChar & 077);
                MatchLoop:
                do {
                    switch (jjstateSet[--i]) {
                        case 0:
                            if ((0x7fffffe87fffffeL & l) == 0L) {
                                break;
                            }
                            kind = 10;
                            jjstateSet[jjnewStateCnt++] = 0;
                            break;
                        default:
                            break;
                    }
                } while (i != startsAt);
            }
            else {
                int i2 = (curChar & 0xff) >> 6;
                long l2 = 1L << (curChar & 077);
                MatchLoop:
                do {
                    switch (jjstateSet[--i]) {
                        default:
                            break;
                    }
                } while (i != startsAt);
            }
            if (kind != 0x7fffffff) {
                jjmatchedKind = kind;
                jjmatchedPos = curPos;
                kind = 0x7fffffff;
            }
            ++curPos;
            if ((i = jjnewStateCnt) == (startsAt = 1 - (jjnewStateCnt = startsAt))) {
                return curPos;
            }
            try {
                curChar = input_stream.readChar();
            }
            catch (java.io.IOException e) {
                return curPos;
            }
        }
    }

    private final int jjMoveStringLiteralDfa0_1() {
        switch (curChar) {
            case 10:
                return jjStopAtPos(0, 6);
            case 13:
                jjmatchedKind = 7;
                return jjMoveStringLiteralDfa1_1(0x100L);
            default:
                return 1;
        }
    }

    private final int jjMoveStringLiteralDfa1_1(long active0) {
        try {
            curChar = input_stream.readChar();
        }
        catch (java.io.IOException e) {
            return 1;
        }
        switch (curChar) {
            case 10:
                if ((active0 & 0x100L) != 0L) {
                    return jjStopAtPos(1, 8);
                }
                break;
            default:
                return 2;
        }
        return 2;
    }

    static final int[] jjnextStates = {
    };
    public static final String[] jjstrLiteralImages = {
            "", null, null, null, null, null, null, null, null, null, null, "\173",
            "\175", "\73",};
    public static final String[] lexStateNames = {
            "DEFAULT",
            "IN_LINE_COMMENT",
    };
    public static final int[] jjnewLexState = {
            -1, -1, -1, -1, -1, 1, 0, 0, 0, -1, -1, -1, -1, -1,
    };
    static final long[] jjtoToken = {
            0x3c01L,
    };
    static final long[] jjtoSkip = {
            0x1feL,
    };
    static final long[] jjtoMore = {
            0x200L,
    };
    protected SimpleCharStream input_stream;
    private final int[] jjrounds = new int[1];
    private final int[] jjstateSet = new int[2];
    protected char curChar;

    public ESFParserTokenManager(SimpleCharStream stream) {
        if (SimpleCharStream.staticFlag) {
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
        }
        input_stream = stream;
    }

    public ESFParserTokenManager(SimpleCharStream stream, int lexState) {
        this(stream);
        switchTo(lexState);
    }

    public void reInit(SimpleCharStream stream) {
        jjmatchedPos = jjnewStateCnt = 0;
        curLexState = defaultLexState;
        input_stream = stream;
        reInitRounds();
    }

    private void reInitRounds() {
        int i;
        jjround = 0x80000001;
        for (i = 1; i-- > 0;) {
            jjrounds[i] = 0x80000000;
        }
    }

    public void reInit(SimpleCharStream stream, int lexState) {
        reInit(stream);
        switchTo(lexState);
    }

    public void switchTo(int lexState) {
        if (lexState >= 2 || lexState < 0) {
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.",
                                    TokenMgrError.INVALID_LEXICAL_STATE);
        }
        else {
            curLexState = lexState;
        }
    }

    protected Token jjFillToken() {
        Token t = Token.newToken(jjmatchedKind);
        t.kind = jjmatchedKind;
        String im = jjstrLiteralImages[jjmatchedKind];
        t.image = (im == null) ? input_stream.getImage() : im;
        t.beginLine = input_stream.getBeginLine();
        t.beginColumn = input_stream.getBeginColumn();
        t.endLine = input_stream.getEndLine();
        t.endColumn = input_stream.getEndColumn();
        return t;
    }

    int curLexState = 0;
    int defaultLexState = 0;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

    public Token getNextToken() {
        int kind;
        Token specialToken = null;
        Token matchedToken;
        int curPos = 0;

        EOFLoop:
        for (; ;) {
            try {
                curChar = input_stream.beginToken();
            }
            catch (java.io.IOException e) {
                jjmatchedKind = 0;
                matchedToken = jjFillToken();
                return matchedToken;
            }

            for (; ;) {
                switch (curLexState) {
                    case 0:
                        try {
                            input_stream.backup(0);
                            while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L) {
                                curChar = input_stream.beginToken();
                            }
                        }
                        catch (java.io.IOException e1) {
                            continue EOFLoop;
                        }
                        jjmatchedKind = 0x7fffffff;
                        jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_0();
                        break;
                    case 1:
                        jjmatchedKind = 0x7fffffff;
                        jjmatchedPos = 0;
                        curPos = jjMoveStringLiteralDfa0_1();
                        if (jjmatchedPos == 0 && jjmatchedKind > 9) {
                            jjmatchedKind = 9;
                        }
                        break;
                }
                if (jjmatchedKind != 0x7fffffff) {
                    if (jjmatchedPos + 1 < curPos) {
                        input_stream.backup(curPos - jjmatchedPos - 1);
                    }
                    if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                        matchedToken = jjFillToken();
                        if (jjnewLexState[jjmatchedKind] != -1) {
                            curLexState = jjnewLexState[jjmatchedKind];
                        }
                        return matchedToken;
                    }
                    else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
                        if (jjnewLexState[jjmatchedKind] != -1) {
                            curLexState = jjnewLexState[jjmatchedKind];
                        }
                        continue EOFLoop;
                    }
                    if (jjnewLexState[jjmatchedKind] != -1) {
                        curLexState = jjnewLexState[jjmatchedKind];
                    }
                    curPos = 0;
                    jjmatchedKind = 0x7fffffff;
                    try {
                        curChar = input_stream.readChar();
                        continue;
                    }
                    catch (java.io.IOException e1) {
                    }
                }
                int error_line = input_stream.getEndLine();
                int error_column = input_stream.getEndColumn();
                String error_after = null;
                boolean EOFSeen = false;
                try {
                    input_stream.readChar();
                    input_stream.backup(1);
                }
                catch (java.io.IOException e1) {
                    EOFSeen = true;
                    error_after = curPos <= 1 ? "" : input_stream.getImage();
                    if (curChar == '\n' || curChar == '\r') {
                        error_line++;
                        error_column = 0;
                    }
                    else {
                        error_column++;
                    }
                }
                if (!EOFSeen) {
                    input_stream.backup(1);
                    error_after = curPos <= 1 ? "" : input_stream.getImage();
                }
                throw new TokenMgrError(EOFSeen,
                                        curLexState,
                                        error_line,
                                        error_column,
                                        error_after,
                                        curChar,
                                        TokenMgrError.LEXICAL_ERROR);
            }
        }
    }

}