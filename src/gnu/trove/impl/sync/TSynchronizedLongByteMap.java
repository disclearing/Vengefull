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

package gnu.trove.impl.sync;

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
import java.io.ObjectOutputStream;
import java.io.IOException;

public class TSynchronizedLongByteMap implements TLongByteMap, Serializable {
	private static final long serialVersionUID = 1978198479659022715L;

	private final TLongByteMap m; // Backing Map
	final Object mutex; // Object on which to synchronize

	public TSynchronizedLongByteMap(TLongByteMap m) {
		if (m == null)
			throw new NullPointerException();
		this.m = m;
		mutex = this;
	}

	public TSynchronizedLongByteMap(TLongByteMap m, Object mutex) {
		this.m = m;
		this.mutex = mutex;
	}

	@Override
	public int size() {
		synchronized (mutex) {
			return m.size();
		}
	}

	@Override
	public boolean isEmpty() {
		synchronized (mutex) {
			return m.isEmpty();
		}
	}

	@Override
	public boolean containsKey(long key) {
		synchronized (mutex) {
			return m.containsKey(key);
		}
	}

	@Override
	public boolean containsValue(byte value) {
		synchronized (mutex) {
			return m.containsValue(value);
		}
	}

	@Override
	public byte get(long key) {
		synchronized (mutex) {
			return m.get(key);
		}
	}

	@Override
	public byte put(long key, byte value) {
		synchronized (mutex) {
			return m.put(key, value);
		}
	}

	@Override
	public byte remove(long key) {
		synchronized (mutex) {
			return m.remove(key);
		}
	}

	@Override
	public void putAll(Map<? extends Long, ? extends Byte> map) {
		synchronized (mutex) {
			m.putAll(map);
		}
	}

	@Override
	public void putAll(TLongByteMap map) {
		synchronized (mutex) {
			m.putAll(map);
		}
	}

	@Override
	public void clear() {
		synchronized (mutex) {
			m.clear();
		}
	}

	private transient TLongSet keySet = null;
	private transient TByteCollection values = null;

	@Override
	public TLongSet keySet() {
		synchronized (mutex) {
			if (keySet == null)
				keySet = new TSynchronizedLongSet(m.keySet(), mutex);
			return keySet;
		}
	}

	@Override
	public long[] keys() {
		synchronized (mutex) {
			return m.keys();
		}
	}

	@Override
	public long[] keys(long[] array) {
		synchronized (mutex) {
			return m.keys(array);
		}
	}

	@Override
	public TByteCollection valueCollection() {
		synchronized (mutex) {
			if (values == null)
				values = new TSynchronizedByteCollection(m.valueCollection(), mutex);
			return values;
		}
	}

	@Override
	public byte[] values() {
		synchronized (mutex) {
			return m.values();
		}
	}

	@Override
	public byte[] values(byte[] array) {
		synchronized (mutex) {
			return m.values(array);
		}
	}

	@Override
	public TLongByteIterator iterator() {
		return m.iterator(); // Must be manually synched by user!
	}

	// these are unchanging over the life of the map, no need to lock
	@Override
	public long getNoEntryKey() {
		return m.getNoEntryKey();
	}

	@Override
	public byte getNoEntryValue() {
		return m.getNoEntryValue();
	}

	@Override
	public byte putIfAbsent(long key, byte value) {
		synchronized (mutex) {
			return m.putIfAbsent(key, value);
		}
	}

	@Override
	public boolean forEachKey(TLongProcedure procedure) {
		synchronized (mutex) {
			return m.forEachKey(procedure);
		}
	}

	@Override
	public boolean forEachValue(TByteProcedure procedure) {
		synchronized (mutex) {
			return m.forEachValue(procedure);
		}
	}

	@Override
	public boolean forEachEntry(TLongByteProcedure procedure) {
		synchronized (mutex) {
			return m.forEachEntry(procedure);
		}
	}

	@Override
	public void transformValues(TByteFunction function) {
		synchronized (mutex) {
			m.transformValues(function);
		}
	}

	@Override
	public boolean retainEntries(TLongByteProcedure procedure) {
		synchronized (mutex) {
			return m.retainEntries(procedure);
		}
	}

	@Override
	public boolean increment(long key) {
		synchronized (mutex) {
			return m.increment(key);
		}
	}

	@Override
	public boolean adjustValue(long key, byte amount) {
		synchronized (mutex) {
			return m.adjustValue(key, amount);
		}
	}

	@Override
	public byte adjustOrPutValue(long key, byte adjust_amount, byte put_amount) {
		synchronized (mutex) {
			return m.adjustOrPutValue(key, adjust_amount, put_amount);
		}
	}

	@Override
	public boolean equals(Object o) {
		synchronized (mutex) {
			return m.equals(o);
		}
	}

	@Override
	public int hashCode() {
		synchronized (mutex) {
			return m.hashCode();
		}
	}

	@Override
	public String toString() {
		synchronized (mutex) {
			return m.toString();
		}
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		synchronized (mutex) {
			s.defaultWriteObject();
		}
	}
}
