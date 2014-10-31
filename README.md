#JavaCommentRemover
---

##What is JavaCommentRemover?

JavaCommentRemover is a simple tool which can remove all comments in .java file. Inspired by Finite State Machine(FSM).

JavaCommentRemover是一个去除Java文件中所有注释的工具。使用简单的有限状态机(Finite State Machine)实现。

Done:

* remove multi-line comments like  /* xxx */
* remove single-line comments like // xxx
* symbol such as /\* xxx\*/ or // in String would not be affected by the tool.
<br></br>
* 去除/* xxx */ 形式的多行注释
* 去除以//开头的单行注释 
* 字符串中的/\* xxx\*/ 不会受到影响

TODO:

* implements the case of handling escape characters
<br></br>
* 加入处理转义字符的情况
