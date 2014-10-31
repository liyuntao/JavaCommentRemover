#JavaCommentRemover
---

##What is JavaCommentRemover?

JavaCommentRemover是一个去除Java文件中所有注释的工具。使用简单的有限状态机(Finite State Machine)实现。

Done:

* 去除/* xxx */ 形式的多行注释
* 去除以//开头的单行注释 
* 字符串中的/* xxx*/ 不会受到影响

TODO:

* 加入处理转义字符的情况
