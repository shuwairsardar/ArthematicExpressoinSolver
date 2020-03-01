ArthematicExpressoinSolver
--------------------------

This repository contains and artematic epression solver or eqation solver which can solve simple equations 

Overview
-------

This solver used linear apporch to sovle eqations. Regular expression are used to parse expressions sequential sovle them and build 
new update list every time

E.g

2*3+(10+3)+(3-1)*(2^4)/2  will solve in follwing sequence in list

1) First blackets will slpit and form list like below

2*3+
10+3
+
3-1
*
2^4
/2

2) Than it will check for ending line operators and start line operators and form list like below

2*3
+
10+3
+
3-1
*
2^4
/
2

3) It will than solve valid expressions and form list like below

6
+
13
+
2
*
8
/
2

4) Now will solve ^ than mul div and than plus minus in order to give 

35

Currently double bracket is not supported expressions like 
3-2((1+2)/(7/8))*3  it will give invalid in this case



