# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        return helper(root)


def helper(root):
    if root == None:
        return 0
    if root.left == None and root.right == None:
        return 1
    return 1 + max(helper(root.left), helper(root.right))