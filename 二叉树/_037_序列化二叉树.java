package 二叉树;

import apple.laf.JRSUIUtils;

import java.util.*;

public class _037_序列化二叉树 {
    /**
     *
     */
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
//        String res = serialize(root);
//        System.out.println(res);
//        System.out.println();
        String data = "[1]";
        TreeNode res1 = deserialize(data);
        System.out.println(res1.val);
//        String str = "小学,初中,高中,大专,本科,研究生,博士";
//        String[] buff = str.split(",");
//        for(int i=0;i<buff.length;i++){
//            System.out.print(buff[i]);
//        }
    }

    /**
     * 序列化二叉树，把二叉树输出为一个字符串
     * @param root
     * @return
     */
    public static String serialize(TreeNode root) {
        if(root == null)
            return ""; //返回一个字符串
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            TreeNode node = queue.poll(); //抛出一个节点
            if(node != null){
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else
                sb.append("null" + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
    /**
     * 反序列化，将字符串反序列化为一个二叉树
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if(data.equals("[]"))
            throw new RuntimeException("空指针异常啦");
        String[] str = data.substring(1, data.length() - 1).split(",");
//        for(int j = 0; j < str.length; j ++){
//            System.out.print(str[j] + " ");
//        }
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            TreeNode node = queue.poll();
            if(i< str.length && (! str[i].equals("null"))){   //用equals比较的是内容 如果用！=的话 会认为内存地址不一样就通过
                //还有就是得注意拦截一下i的取值范围 别出界溢出了
               node.left = new TreeNode(Integer.parseInt(str[i]));
               queue.add(node.left);
            }
            i ++;
            if(i < str.length && (! str[i].equals("null"))){
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.right);
            }
            i ++;
        }
        return root;
    }
}
