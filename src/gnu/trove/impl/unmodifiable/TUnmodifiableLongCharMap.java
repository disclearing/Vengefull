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

public class TUnmodifiableLongCharMap implements TLongCharMap, Serializable {
	private static final long serialVersionUID = -1034234728574286014L;

	private final TLongCharMap m;

	public TUnmodifiableLongCharMap(TLongCharMap m) {
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
	public boolean containsKey(long key) {
		return m.containsKey(key);
	}

	@Override
	public boolean containsValue(char val) {
		return m.containsValue(val);
	}

	@Override
	public char get(long key) {
		return m.get(key);
	}

	@Override
	public char put(long key, char value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public char remove(long key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(TLongCharMap m) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(Map<? extends Long, ? extends Character> map) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	private transient TLongSet keySet = null;
	private transient TCharCollection values = null;

	@Override
	public TLongSet keySet() {
		if (keySet == null)
			keySet = TCollections.unmodifiableSet(m.keySet());
		return keySet;
	}

	@Override
	public long[] keys() {
		return m.keys();
	}

	@Override
	public long[] keys(long[] array) {
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
	public long getNoEntryKey() {
		return m.getNoEntryKey();
	}

	@Override
	public char getNoEntryValue() {
		return m.getNoEntryValue();
	}

	@Override
	public boolean forEachKey(TLongProcedure procedure) {
		return m.forEachKey(procedure);
	}

	@Override
	public boolean forEachValue(TCharProcedure procedure) {
		return m.forEachValue(procedure);
	}

	@Override
	public boolean forEachEntry(TLongCharProcedure procedure) {
		return m.forEachEntry(procedure);
	}

	@Override
	public TLongCharIterator iterator() {
		return new TLongCharIterator() {
			TLongCharIterator iter = m.iterator();

			@Override
			public long key() {
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
	public char putIfAbsent(long key, char value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void transformValues(TCharFunction function) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainEntries(TLongCharProcedure procedure) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean increment(long key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean adjustValue(long key, char amount) {
		throw new UnsupportedOperationException();
	}

	@Override
	public char adjustOrPutValue(long key, char adjust_amount, char put_amount) {
		throw new UnsupportedOperationException();
	}
}
