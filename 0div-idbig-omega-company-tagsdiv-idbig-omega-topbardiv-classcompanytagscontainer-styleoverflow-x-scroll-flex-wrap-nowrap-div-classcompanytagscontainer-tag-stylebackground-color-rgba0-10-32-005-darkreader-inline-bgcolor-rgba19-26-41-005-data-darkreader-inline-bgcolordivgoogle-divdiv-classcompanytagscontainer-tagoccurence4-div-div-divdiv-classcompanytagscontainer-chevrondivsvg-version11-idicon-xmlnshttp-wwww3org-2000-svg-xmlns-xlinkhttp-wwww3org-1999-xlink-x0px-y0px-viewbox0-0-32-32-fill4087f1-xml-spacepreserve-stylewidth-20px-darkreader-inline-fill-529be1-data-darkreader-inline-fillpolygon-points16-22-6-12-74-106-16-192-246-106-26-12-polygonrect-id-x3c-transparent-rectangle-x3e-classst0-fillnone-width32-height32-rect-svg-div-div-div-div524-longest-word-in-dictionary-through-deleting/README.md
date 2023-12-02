<h2><a href="https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05); --darkreader-inline-bgcolor: rgba(19, 26, 41, 0.05);" data-darkreader-inline-bgcolor=""><div>Google</div><div class="companyTagsContainer--tagOccurence">4</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px; --darkreader-inline-fill: #529be1;" data-darkreader-inline-fill=""><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>524. Longest Word in Dictionary through Deleting</a></h2><h3>Medium</h3><hr><div><p>Given a string <code>s</code> and a string array <code>dictionary</code>, return <em>the longest string in the dictionary that can be formed by deleting some of the given string characters</em>. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
<strong>Output:</strong> "apple"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abpcplea", dictionary = ["a","b","c"]
<strong>Output:</strong> "a"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>1 &lt;= dictionary.length &lt;= 1000</code></li>
	<li><code>1 &lt;= dictionary[i].length &lt;= 1000</code></li>
	<li><code>s</code> and <code>dictionary[i]</code> consist of lowercase English letters.</li>
</ul>
</div>