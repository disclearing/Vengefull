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

public class TUnmodifiableShortLongMap implements TShortLongMap, Serializable {
	private static final long serialVersionUID = -1034234728574286014L;

	private final TShortLongMap m;

	public TUnmodifiableShortLongMap(TShortLongMap m) {
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
	public boolean containsKey(short key) {
		return m.containsKey(key);
	}

	@Override
	public boolean containsValue(long val) {
		return m.containsValue(val);
	}

	@Override
	public long get(short key) {
		return m.get(key);
	}

	@Override
	public long put(short key, long value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long remove(short key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(TShortLongMap m) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void putAll(Map<? extends Short, ? extends Long> map) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	private transient TShortSet keySet = null;
	private transient TLongCollection values = null;

	@Override
	public TShortSet keySet() {
		if (keySet == null)
			keySet = TCollections.unmodifiableSet(m.keySet());
		return keySet;
	}

	@Override
	public short[] keys() {
		return m.keys();
	}

	@Override
	public short[] keys(short[] array) {
		return m.keys(array);
	}

	@Override
	public TLongCollection valueCollection() {
		if (values == null)
			values = TCollections.unmodifiableCollection(m.valueCollection());
		return values;
	}

	@Override
	public long[] values() {
		return m.values();
	}

	@Override
	public long[] values(long[] array) {
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
	public short getNoEntryKey() {
		return m.getNoEntryKey();
	}

	@Override
	public long getNoEntryValue() {
		return m.getNoEntryValue();
	}

	@Override
	public boolean forEachKey(TShortProcedure procedure) {
		return m.forEachKey(procedure);
	}

	@Override
	public boolean forEachValue(TLongProcedure procedure) {
		return m.forEachValue(procedure);
	}

	@Override
	public boolean forEachEntry(TShortLongProcedure procedure) {
		return m.forEachEntry(procedure);
	}

	@Override
	public TShortLongIterator iterator() {
		return new TShortLongIterator() {
			TShortLongIterator iter = m.iterator();

			@Override
			public short key() {
				return iter.key();
			}

			@Override
			public long value() {
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
			public long setValue(long val) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public long putIfAbsent(short key, long value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void transformValues(TLongFunction function) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainEntries(TShortLongProcedure procedure) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean increment(short key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean adjustValue(short key, long amount) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long adjustOrPutValue(short key, long adjust_amount, long put_amount) {
		throw new UnsupportedOperationException();
	}
}