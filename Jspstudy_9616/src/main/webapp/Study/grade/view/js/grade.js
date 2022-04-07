/**

 */
 
 const tbody = document.querySelector("tbody");
 const subjectPlusBtn = document.querySelector(".subject-plus");
 
 subjectPlusBtn.onclick = () => {
	const tr = document.createElement("tr");
	tr.innerHTML = `
	<td><input type="text" name="subject"></td>
	<td>
		<select name="grade">
			<option value="A+">A+</option>
			<option value="A">A</option>
			<option value="B+">B+</option>
			<option value="B">B</option>
			<option value="C+">C+</option>
			<option value="C">C</option>
			<option value="D+">D+</option>
			<option value="D">D</option>
			<option value="F">F</option>
		</select>						
	</td>
	<td><input type="text" name="time"></td>
	`
	tbody.appendChild(tr);
}