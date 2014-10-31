#JavaCommentRemover
---

##What is JavaCommentRemover?

JavaCommentRemover is a simple tool which can remove all comments in .java file. Inspired by Finite State Machine(FSM).

JavaCommentRemover是一个去除Java文件中所有注释的工具。使用简单的有限状态机(Finite State Machine)实现。

![StateChart](https://github.com/liyuntao/JavaCommentRemover/raw/master/StateChart.png)

Done:

* remove multi-line comments like  /* xxx */
* remove single-line comments like // xxx
* symbol which could trigger the state shift will not has any effect in char and String. Such as String s = "abc/*\*part of Str\*/def"
* escape character in char or String will not affect the judgement of comments.
<br></br>
* 去除/* xxx */ 形式的多行注释
* 去除以//开头的单行注释 
* char, String中可触发状态转换的特殊字符/\* xxx\*/ 不会影响状态转移 如 String s = "abc/*\*part of Str\*/def"
* char, String中的转义字符与被转义字符不会影响注释的判断与去除 如 \' \" \\