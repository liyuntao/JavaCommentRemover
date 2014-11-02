package state;

import state.State;

import java.io.StringWriter;

/**
 * Created by liyuntao on 2014/10/30.
 */
public class StateContext {
    private State state = State.InitState;

    private State prevState = State.InitState;

    public State getPrevState() {
        return prevState;
    }

    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void changeState(char c, StringWriter writer) {
        state.changeState(c, writer, this);
    }
}
