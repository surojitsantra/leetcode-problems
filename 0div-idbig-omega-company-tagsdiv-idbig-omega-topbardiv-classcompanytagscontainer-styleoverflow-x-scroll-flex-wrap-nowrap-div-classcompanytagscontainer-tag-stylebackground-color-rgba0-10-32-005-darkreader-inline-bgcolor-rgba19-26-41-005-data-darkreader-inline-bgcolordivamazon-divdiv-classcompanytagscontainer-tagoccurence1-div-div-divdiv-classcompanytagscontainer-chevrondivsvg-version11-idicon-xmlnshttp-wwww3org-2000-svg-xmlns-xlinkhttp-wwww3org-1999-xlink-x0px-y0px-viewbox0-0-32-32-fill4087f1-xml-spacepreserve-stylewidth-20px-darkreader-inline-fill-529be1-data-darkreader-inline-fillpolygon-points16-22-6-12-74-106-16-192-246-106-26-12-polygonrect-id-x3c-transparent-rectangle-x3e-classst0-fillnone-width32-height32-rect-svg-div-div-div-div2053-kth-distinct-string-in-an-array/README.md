<h2><a href="https://leetcode.com/problems/kth-distinct-string-in-an-array/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05); --darkreader-inline-bgcolor: rgba(19, 26, 41, 0.05);" data-darkreader-inline-bgcolor=""><div>Amazon</div><div class="companyTagsContainer--tagOccurence">1</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px; --darkreader-inline-fill: #529be1;" data-darkreader-inline-fill=""><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>2053. Kth Distinct String in an Array</a></h2><h3>Easy</h3><hr><div><p>A <strong>distinct string</strong> is a string that is present only <strong>once</strong> in an array.</p>

<p>Given an array of strings <code>arr</code>, and an integer <code>k</code>, return <em>the </em><code>k<sup>th</sup></code><em> <strong>distinct string</strong> present in </em><code>arr</code>. If there are <strong>fewer</strong> than <code>k</code> distinct strings, return <em>an <strong>empty string </strong></em><code>""</code>.</p>

<p>Note that the strings are considered in the <strong>order in which they appear</strong> in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = ["d","b","c","b","c","a"], k = 2
<strong>Output:</strong> "a"
<strong>Explanation:</strong>
The only distinct strings in arr are "d" and "a".
"d" appears 1<sup>st</sup>, so it is the 1<sup>st</sup> distinct string.
"a" appears 2<sup>nd</sup>, so it is the 2<sup>nd</sup> distinct string.
Since k == 2, "a" is returned. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = ["aaa","aa","a"], k = 1
<strong>Output:</strong> "aaa"
<strong>Explanation:</strong>
All strings in arr are distinct, so the 1<sup>st</sup> string "aaa" is returned.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = ["a","b","a"], k = 3
<strong>Output:</strong> ""
<strong>Explanation:</strong>
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= arr.length &lt;= 1000</code></li>
	<li><code>1 &lt;= arr[i].length &lt;= 5</code></li>
	<li><code>arr[i]</code> consists of lowercase English letters.</li>
</ul>
</div>