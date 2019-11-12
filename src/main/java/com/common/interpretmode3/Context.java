package com.common.interpretmode3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
	
	private String  context;
	
	private Node expression;
	
	public void setExpression(Node expression) {
		this.expression = expression;
	}

	Stack<Node> stack = new Stack<Node>();
	Stack<String> operation = new Stack<String>();
	
	private Map<String, Integer> level = new HashMap<String, Integer>();
	public Context(String context,Map<String,Integer> level){
		this.context = context;
		this.level = level;
	}
	
	/**
	 * 通过解析原始算法字符串，决定操作符栈中运算符优先级
	 */
	public void analysis(){
		char[] origin = context.toCharArray();
		
		for (int i = 0; i < origin.length; i++) {
			if(origin[i]!='+' && origin[i]!='-'&&origin[i]!='*'&&origin[i]!='/'){
				stack.push(new ValueNode(String.valueOf(origin[i])));
			}else{
				if(operation.empty()){
					operation.push(String.valueOf(origin[i]));
				}else{
					combine(String.valueOf(origin[i]));
				}
			}
		}
	}
	
	/**
	 * 判断操作符优先级
	 * @param left 操作符
	 * @param right 操作符
	 * @return 
	 */
	private boolean compare(String left, String right){
		return level.get(left) > level.get(right);
	}
	
	/**
	 * 递归判断新加入操作符栈中新加入的操作符应该处于的位置，保证优先级高的操作符位于栈顶
	 * @param curopt
	 */
	private void combine(String curopt){
		if(compare(curopt,operation.peek())){
			operation.push(curopt);
		}else {
			Node right = stack.pop();
			Node left = stack.pop();
			switch (operation.pop()) {
			case "*":
				stack.push(new MulNode(left, right));
				break;
			case "/":
				stack.push(new DivNode(left, right));
				break;
			case "-":
				stack.push(new SubNode(left, right));
				break;

			default:
				stack.push(new AddNode(left, right));
				
				break;
			}
			combine(curopt);
		}
	}
	
	/**
	 * 分别取出操作符栈中操作符，和数值栈中的两个操作数进行组合计算，最终得到唯一的结果
	 * @return
	 */
	public Node getExpression(){
		while(!operation.empty()){
			switch (operation.pop()) {
			case "/":
				Node right = stack.pop();
				Node left = stack.pop();
				expression = new DivNode(left, right);
				stack.push(expression);
				break;
			case "*":
				expression = new MulNode(stack.pop(), stack.pop());
				stack.push(expression);
				break;
			case "-":
				Node rightNode = stack.pop();
				Node leftNode = stack.pop();
				expression = new SubNode(leftNode, rightNode);
				stack.push(expression);
				break;

			default:
				expression = new AddNode(stack.pop(), stack.pop());
				stack.push(expression);
				break;
			}
		}
		return stack.peek();
		
	}
	
	public void execute(){
		analysis();
		expression = getExpression();
	}
	
}
