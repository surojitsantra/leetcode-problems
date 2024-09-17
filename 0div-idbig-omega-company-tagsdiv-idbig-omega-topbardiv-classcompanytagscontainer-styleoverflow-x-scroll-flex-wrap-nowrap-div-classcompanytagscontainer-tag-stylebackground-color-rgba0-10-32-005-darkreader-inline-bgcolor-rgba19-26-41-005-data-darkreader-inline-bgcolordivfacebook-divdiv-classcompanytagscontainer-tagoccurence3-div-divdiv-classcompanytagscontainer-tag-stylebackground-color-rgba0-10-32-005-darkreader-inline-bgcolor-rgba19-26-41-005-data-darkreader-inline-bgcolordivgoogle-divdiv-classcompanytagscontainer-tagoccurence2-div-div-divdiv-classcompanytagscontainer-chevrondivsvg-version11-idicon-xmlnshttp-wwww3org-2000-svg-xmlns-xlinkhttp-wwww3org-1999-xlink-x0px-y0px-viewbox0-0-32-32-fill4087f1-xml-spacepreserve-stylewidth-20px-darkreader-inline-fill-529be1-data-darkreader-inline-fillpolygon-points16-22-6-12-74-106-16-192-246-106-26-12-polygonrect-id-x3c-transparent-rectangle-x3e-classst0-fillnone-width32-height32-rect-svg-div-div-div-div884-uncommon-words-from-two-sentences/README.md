<h2><a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05); --darkreader-inline-bgcolor: rgba(19, 26, 41, 0.05);" data-darkreader-inline-bgcolor=""><div>Facebook</div><div class="companyTagsContainer--tagOccurence">3</div></div><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05); --darkreader-inline-bgcolor: rgba(19, 26, 41, 0.05);" data-darkreader-inline-bgcolor=""><div>Google</div><div class="companyTagsContainer--tagOccurence">2</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px; --darkreader-inline-fill: #529be1;" data-darkreader-inline-fill=""><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>884. Uncommon Words from Two Sentences</a></h2><h3>Easy</h3><hr><div><p>A <strong>sentence</strong> is a string of single-space separated words where each word consists only of lowercase letters.</p>

<p>A word is <strong>uncommon</strong> if it appears exactly once in one of the sentences, and <strong>does not appear</strong> in the other sentence.</p>

<p>Given two <strong>sentences</strong> <code>s1</code> and <code>s2</code>, return <em>a list of all the <strong>uncommon words</strong></em>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s1 = "this apple is sweet", s2 = "this apple is sour"</span></p>

<p><strong>Output:</strong> <span class="example-io">["sweet","sour"]</span></p>

<p><strong>Explanation:</strong></p>

<p>The word <code>"sweet"</code> appears only in <code>s1</code>, while the word <code>"sour"</code> appears only in <code>s2</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s1 = "apple apple", s2 = "banana"</span></p>

<p><strong>Output:</strong> <span class="example-io">["banana"]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length &lt;= 200</code></li>
	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters and spaces.</li>
	<li><code>s1</code> and <code>s2</code> do not have leading or trailing spaces.</li>
	<li>All the words in <code>s1</code> and <code>s2</code> are separated by a single space.</li>
</ul>
</div>