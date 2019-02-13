///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2008, Robert D. Eden All Rights Reserved.
// Copyright (c) 2009, Jeff Randall All Rights Reserved.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

package gnu.trove.impl.unmodifiable;

//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////

////////////////////////////////////////////////////////////
// THIS IS AN IMPLEMENTATION CLASS. DO NOT USE DIRECTLY!  //
// Access to these methods should be through TCollections //
////////////////////////////////////////////////////////////

import gnu.trove.iterator.*;
import gnu.trove.procedure.*;
import gnu.trove.set.*;
import gnu.trove.function.*;
import gnu.trove.map.*;
import gnu.trove.*;

import java.util.Map;
import java.io.Serializable;

public class TUnmodifiableIntCharMap implements TIntCharMap, Serializable {
	private static final long serialVersionUID = -1034234728574286014L;

	private final TIntCharMap m;

	public TUnmodifiableIntCharMap(TIntCharMap m) {
		if (m == null)
			throw new NullPointerException();
		this.m = m;
	}

	@Override
	public int size() {
		return m.size();
	}

	@Override
	public boolean isEmpty() {
		return m.isEmpty();
	}

	@Override
	public boolean containsKey(int key) {
		return m.containsKey(key);
	}

	@Override
	public boolean containsValue(char val) {
		return m.containsValue(val);
	}

	@Override
	public char get(int key) {
		return m.get(key);
	}

	@Override
	public char put(int key, char value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public char remove(int key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(TIntCharMap m) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Character> map) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	private transient TIntSet keySet = null;
	private transient TCharCollection values = null;

	@Override
	public TIntSet keySet() {
		if (keySet == null)
			keySet = TCollections.unmodifiableSet(m.keySet());
		return keySet;
	}

	@Override
	public int[] keys() {
		return m.keys();
	}

	@Override
	public int[] keys(int[] array) {
		return m.keys(array);
	}

	@Override
	public TCharCollection valueCollection() {
		if (values == null)
			values = TCollections.unmodifiableCollection(m.valueCollection());
		return values;
	}

	@Override
	public char[] values() {
		return m.values();
	}

	@Override
	public char[] values(char[] array) {
		return m.values(array);
	}

	@Override
	public boolean equals(Object o) {
		return o == this || m.equals(o);
	}

	@Override
	public int hashCode() {
		return m.hashCode();
	}

	@Override
	public String toString() {
		return m.toString();
	}

	@Override
	public int getNoEntryKey() {
		return m.getNoEntryKey();
	}

	@Override
	public char getNoEntryValue() {
		return m.getNoEntryValue();
	}

	@Override
	public boolean forEachKey(TIntProcedure procedure) {
		return m.forEachKey(procedure);
	}

	@Override
	public boolean forEachValue(TCharProcedure procedure) {
		return m.forEachValue(procedure);
	}

	@Override
	public boolean forEachEntry(TIntCharProcedure procedure) {
		return m.forEachEntry(procedure);
	}

	@Override
	public TIntCharIterator iterator() {
		return new TIntCharIterator() {
			TIntCharIterator iter = m.iterator();

			@Override
			public int key() {
				return iter.key();
			}

			@Override
			public char value() {
				return iter.value();
			}

			@Override
			public void advance() {
				iter.advance();
			}

			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			@Override
			public char setValue(char val) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public char putIfAbsent(int key, char value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void transformValues(TCharFunction function) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainEntries(TIntCharProcedure procedure) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean increment(int key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean adjustValue(int key, char amount) {
		throw new UnsupportedOperationException();
	}

	@Override
	public char adjustOrPutValue(int key, char adjust_amount, char put_amount) {
		throw new UnsupportedOperationException();
	}
}
