<h2><a href="https://leetcode.com/problems/sum-of-digits-of-string-after-convert/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05); --darkreader-inline-bgcolor: rgba(19, 26, 41, 0.05);" data-darkreader-inline-bgcolor=""><div>Microsoft</div><div class="companyTagsContainer--tagOccurence">1</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px; --darkreader-inline-fill: #529be1;" data-darkreader-inline-fill=""><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1945. Sum of Digits of String After Convert</a></h2><h3>Easy</h3><hr><div><p>You are given a string <code>s</code> consisting of lowercase English letters, and an integer <code>k</code>.</p>

<p>First, <strong>convert</strong> <code>s</code> into an integer by replacing each letter with its position in the alphabet (i.e., replace <code>'a'</code> with <code>1</code>, <code>'b'</code> with <code>2</code>, ..., <code>'z'</code> with <code>26</code>). Then, <strong>transform</strong> the integer by replacing it with the <strong>sum of its digits</strong>. Repeat the <strong>transform</strong> operation <code>k</code><strong> times</strong> in total.</p>

<p>For example, if <code>s = "zbax"</code> and <code>k = 2</code>, then the resulting integer would be <code>8</code> by the following operations:</p>

<ul>
	<li><strong>Convert</strong>: <code>"zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124</code></li>
	<li><strong>Transform #1</strong>: <code>262124 ➝ 2 + 6 + 2 + 1 + 2 + 4&nbsp;➝ 17</code></li>
	<li><strong>Transform #2</strong>: <code>17 ➝ 1 + 7 ➝ 8</code></li>
</ul>

<p>Return <em>the resulting integer after performing the operations described above</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "iiii", k = 1
<strong>Output:</strong> 36
<strong>Explanation:</strong> The operations are as follows:
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
Thus the resulting integer is 36.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "leetcode", k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> The operations are as follows:
- Convert: "leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
- Transform #1: 12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
- Transform #2: 33 ➝ 3 + 3 ➝ 6
Thus the resulting integer is 6.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "zbax", k = 2
<strong>Output:</strong> 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 10</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div>