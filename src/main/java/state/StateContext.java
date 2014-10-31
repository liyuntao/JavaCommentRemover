package state;

import state.State;

/**
 * Created by liyuntao on 2014/10/30.
 */
public class StateContext {
    private State state = State.InitState;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void changeState(char c) {
        state.changeState(c, this);
    }
}
