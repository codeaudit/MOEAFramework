/* Copyright 2009-2012 David Hadka
 * 
 * This file is part of the MOEA Framework.
 * 
 * The MOEA Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or (at your 
 * option) any later version.
 * 
 * The MOEA Framework is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public 
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License 
 * along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.moeaframework.util.tree;

/**
 * The node for comparing two numbers for equality.
 * 
 * <table border="1" cellpadding="3" cellspacing="0">
 *   <tr class="TableHeadingColor">
 *     <th width="25%" align="left">Name</th>
 *     <th width="25%" align="left">Type</th>
 *     <th width="50%" align="left">Description</th>
 *   </tr>
 *   <tr>
 *     <td>Argument 1</td>
 *     <td>Number</td>
 *     <td>The first number</td>
 *   </tr>
 *   <tr>
 *     <td>Argument 2</td>
 *     <td>Number</td>
 *     <td>The second number</td>
 *   </tr>
 *   <tr>
 *     <td>Return Value</td>
 *     <td>Boolean</td>
 *     <td>{@code true} if the two numbers equals; {@code false} otherwise</td>
 *   </tr>
 * </table>
 */
public class Equals extends Node {
	
	/**
	 * Constructs a new node for comparing two numbers for equality.
	 */
	public Equals() {
		super(Boolean.class, Number.class, Number.class);
	}

	@Override
	public Equals copyNode() {
		return new Equals();
	}

	@Override
	public Boolean evaluate(Environment environment) {
		Number n1 = (Number)getArgument(0).evaluate(environment);
		Number n2 = (Number)getArgument(1).evaluate(environment);
		
		return n1.equals(n2);
	}

}
