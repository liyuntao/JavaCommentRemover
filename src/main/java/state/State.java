package state;

/**
 * Created by liyuntao on 2014/10/30.
 */
public enum State implements IState{
    InitState {
        @Override
        public void changeState(char c, StateContext sc) {
            if(c == '/') {
                sc.setState(State.WaitAsteriskOrSlash);
            } else {
                System.out.print(c);
                sc.setState(State.CodeHandleState);
            }
        }
    },

    CodeHandleState {
        @Override
        public void changeState(char c, StateContext sc) {
            if(c == '/') {
                sc.setState(State.WaitAsteriskOrSlash);
            } else if(c == '"') {
                sc.setState(State.StringHandleState);
                System.out.print(c);
            } else if(c == '\'') {
                sc.setState(State.CharHandleState);
                System.out.print(c);
            } else {
                System.out.print(c);
            }
        }
    },

    CharHandleState {
        @Override
        public void changeState(char c, StateContext sc) {
            if(c == '\'') {
                sc.setState(State.CodeHandleState);
                System.out.print(c);
            } else {
                System.out.print(c);
            }
        }
    },

    StringHandleState {
        @Override
        public void changeState(char c, StateContext sc) {
            if(c == '"') {
                sc.setState(State.CodeHandleState);
                System.out.print(c);
            } else {
                System.out.print(c);
            }
        }
    },

    DoubleSlashHandleState {
        @Override
        public void changeState(char c, StateContext sc) {
            if(c != '\n') {
                // do nothing
            } else {
                System.out.print(c);
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
        public void changeState(char c, StateContext sc) {
            if(c == '*') {
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
        public void changeState(char c, StateContext sc) {
            if(c == '*') {
                sc.setState(State.WaitSlashState);
            } else {
                // do nothing
            }
        }
    },

    WaitSlashState {
        @Override
        public void changeState(char c, StateContext sc) {
            if(c == '/') {
                sc.setState(State.CodeHandleState);
            } else if(c == '*') {
                // do nothing
            } else {
                sc.setState(State.CommentHandleState);
            }
        }
    }
}
