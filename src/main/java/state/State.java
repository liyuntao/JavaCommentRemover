package state;

import java.io.StringWriter;

/**
 * Created by liyuntao on 2014/10/30.
 */
public enum State implements IState {
    InitState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '/') {
                sc.setState(State.WaitAsteriskOrSlash);
            } else {
                writer.append(c);
                sc.setState(State.CodeHandleState);
            }
        }
    },

    CodeHandleState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '/') {
                sc.setState(State.WaitAsteriskOrSlash);
            } else if (c == '"') {
                sc.setState(State.StringHandleState);
                writer.append(c);
            } else if (c == '\'') {
                sc.setState(State.CharHandleState);
                writer.append(c);
            } else {
                writer.append(c);
            }
        }
    },

    CharHandleState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '\'') {
                sc.setState(State.CodeHandleState);
                writer.append(c);
            } else if (c == '\\') {
                sc.setPrevState(State.CharHandleState);
                sc.setState(State.EscapeCharacterHandleState);
                writer.append(c);
            } else {
                writer.append(c);
            }
        }
    },

    StringHandleState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '"') {
                sc.setState(State.CodeHandleState);
                writer.append(c);
            } else if (c == '\\') {
                sc.setPrevState(State.StringHandleState);
                sc.setState(State.EscapeCharacterHandleState);
                writer.append(c);
            } else {
                writer.append(c);
            }
        }
    },

    EscapeCharacterHandleState() {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            writer.append(c);
            sc.setState(sc.getPrevState());
        }
    },

    DoubleSlashHandleState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c != '\n') {
                // do nothing
            } else {
                writer.append(c);
                sc.setState(State.CodeHandleState);
            }
        }
    },

    /**
     * according to input_char: * or /
     * switch to multi-line comment state /*
     * or single line comment state //
     */
    WaitAsteriskOrSlash {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '*') {
                sc.setState(State.CommentHandleState);
            } else if (c == '/') {
                sc.setState(State.DoubleSlashHandleState);
            } else {
                System.out.print('/' + c);
                sc.setState(State.CodeHandleState);
            }
        }
    },

    CommentHandleState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '*') {
                sc.setState(State.WaitSlashState);
            } else {
                // do nothing
            }
        }
    },

    WaitSlashState {
        @Override
        public void changeState(char c, StringWriter writer, StateContext sc) {
            if (c == '/') {
                sc.setState(State.CodeHandleState);
            } else if (c == '*') {
                // do nothing
            } else {
                sc.setState(State.CommentHandleState);
            }
        }
    };

    State prevState;

    State() {
    }

    State(State prevState) {
        this.prevState = prevState;
    }

}
