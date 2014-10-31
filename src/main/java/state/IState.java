package FSM.state;

import FSM.StateContext;

/**
 * Created by liyuntao on 2014/10/30.
 */
public interface IState {
    public void changeState(char c, StateContext sc);
}
