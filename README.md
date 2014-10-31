#JavaCommentRemover
---

##What is JavaCommentRemover?

JavaCommentRemover is a simple tool which can remove all comments in .java file. Inspired by Finite State Machine(FSM).

JavaCommentRemover是一个去除Java文件中所有注释的工具。使用简单的有限状态机(Finite State Machine)实现。

![StateChart](https://github.com/liyuntao/JavaCommentRemover/raw/master/StateChart.png)

Done:

* remove multi-line comments like  /* xxx */
* remove single-line comments like // xxx
* symbol such as /\* xxx\*/ or // in String would not be affected by the tool.
* state change will not affected by special char which could trigger state change, such as '/' '*' '"'
<br></br>
* 去除/* xxx */ 形式的多行注释
* 去除以//开头的单行注释 
* 字符串中的/\* xxx\*/ 不会受到影响
* 状态转移不受char中的相关触发字符影响，比如'/' '*' '"'

TODO:


* implements the case of char handling such as '/' '*' '"'
<br></br>
* 加入处理转义字符的情况