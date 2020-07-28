package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_syncupdate_AtheleteRealmProxy extends com.syncupdate.Athelete
    implements RealmObjectProxy, com_syncupdate_AtheleteRealmProxyInterface {

    static final class AtheleteColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long nameIndex;
        long idIndex;
        long client_idIndex;
        long warehouse_idIndex;

        AtheleteColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Athelete");
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.client_idIndex = addColumnDetails("client_id", "client_id", objectSchemaInfo);
            this.warehouse_idIndex = addColumnDetails("warehouse_id", "warehouse_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        AtheleteColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AtheleteColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AtheleteColumnInfo src = (AtheleteColumnInfo) rawSrc;
            final AtheleteColumnInfo dst = (AtheleteColumnInfo) rawDst;
            dst.nameIndex = src.nameIndex;
            dst.idIndex = src.idIndex;
            dst.client_idIndex = src.client_idIndex;
            dst.warehouse_idIndex = src.warehouse_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AtheleteColumnInfo columnInfo;
    private ProxyState<com.syncupdate.Athelete> proxyState;

    com_syncupdate_AtheleteRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AtheleteColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.syncupdate.Athelete>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$client_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.client_idIndex);
    }

    @Override
    public void realmSet$client_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.client_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.client_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$warehouse_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.warehouse_idIndex);
    }

    @Override
    public void realmSet$warehouse_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.warehouse_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.warehouse_idIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Athelete", 4, 0);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("client_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("warehouse_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AtheleteColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AtheleteColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Athelete";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Athelete";
    }

    @SuppressWarnings("cast")
    public static com.syncupdate.Athelete createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.syncupdate.Athelete obj = realm.createObjectInternal(com.syncupdate.Athelete.class, true, excludeFields);

        final com_syncupdate_AtheleteRealmProxyInterface objProxy = (com_syncupdate_AtheleteRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("client_id")) {
            if (json.isNull("client_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'client_id' to null.");
            } else {
                objProxy.realmSet$client_id((int) json.getInt("client_id"));
            }
        }
        if (json.has("warehouse_id")) {
            if (json.isNull("warehouse_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'warehouse_id' to null.");
            } else {
                objProxy.realmSet$warehouse_id((int) json.getInt("warehouse_id"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.syncupdate.Athelete createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.syncupdate.Athelete obj = new com.syncupdate.Athelete();
        final com_syncupdate_AtheleteRealmProxyInterface objProxy = (com_syncupdate_AtheleteRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
            } else if (name.equals("client_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$client_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'client_id' to null.");
                }
            } else if (name.equals("warehouse_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$warehouse_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'warehouse_id' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_syncupdate_AtheleteRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.syncupdate.Athelete.class), false, Collections.<String>emptyList());
        io.realm.com_syncupdate_AtheleteRealmProxy obj = new io.realm.com_syncupdate_AtheleteRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.syncupdate.Athelete copyOrUpdate(Realm realm, AtheleteColumnInfo columnInfo, com.syncupdate.Athelete object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.syncupdate.Athelete) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.syncupdate.Athelete copy(Realm realm, AtheleteColumnInfo columnInfo, com.syncupdate.Athelete newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.syncupdate.Athelete) cachedRealmObject;
        }

        com_syncupdate_AtheleteRealmProxyInterface realmObjectSource = (com_syncupdate_AtheleteRealmProxyInterface) newObject;

        Table table = realm.getTable(com.syncupdate.Athelete.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.nameIndex, realmObjectSource.realmGet$name());
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addInteger(columnInfo.client_idIndex, realmObjectSource.realmGet$client_id());
        builder.addInteger(columnInfo.warehouse_idIndex, realmObjectSource.realmGet$warehouse_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_syncupdate_AtheleteRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.syncupdate.Athelete object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.syncupdate.Athelete.class);
        long tableNativePtr = table.getNativePtr();
        AtheleteColumnInfo columnInfo = (AtheleteColumnInfo) realm.getSchema().getColumnInfo(com.syncupdate.Athelete.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.client_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$client_id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.warehouse_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$warehouse_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.syncupdate.Athelete.class);
        long tableNativePtr = table.getNativePtr();
        AtheleteColumnInfo columnInfo = (AtheleteColumnInfo) realm.getSchema().getColumnInfo(com.syncupdate.Athelete.class);
        com.syncupdate.Athelete object = null;
        while (objects.hasNext()) {
            object = (com.syncupdate.Athelete) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.client_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$client_id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.warehouse_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$warehouse_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.syncupdate.Athelete object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.syncupdate.Athelete.class);
        long tableNativePtr = table.getNativePtr();
        AtheleteColumnInfo columnInfo = (AtheleteColumnInfo) realm.getSchema().getColumnInfo(com.syncupdate.Athelete.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$name = ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.client_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$client_id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.warehouse_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$warehouse_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.syncupdate.Athelete.class);
        long tableNativePtr = table.getNativePtr();
        AtheleteColumnInfo columnInfo = (AtheleteColumnInfo) realm.getSchema().getColumnInfo(com.syncupdate.Athelete.class);
        com.syncupdate.Athelete object = null;
        while (objects.hasNext()) {
            object = (com.syncupdate.Athelete) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$name = ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.client_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$client_id(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.warehouse_idIndex, rowIndex, ((com_syncupdate_AtheleteRealmProxyInterface) object).realmGet$warehouse_id(), false);
        }
    }

    public static com.syncupdate.Athelete createDetachedCopy(com.syncupdate.Athelete realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.syncupdate.Athelete unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.syncupdate.Athelete();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.syncupdate.Athelete) cachedObject.object;
            }
            unmanagedObject = (com.syncupdate.Athelete) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_syncupdate_AtheleteRealmProxyInterface unmanagedCopy = (com_syncupdate_AtheleteRealmProxyInterface) unmanagedObject;
        com_syncupdate_AtheleteRealmProxyInterface realmSource = (com_syncupdate_AtheleteRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$client_id(realmSource.realmGet$client_id());
        unmanagedCopy.realmSet$warehouse_id(realmSource.realmGet$warehouse_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Athelete = proxy[");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{client_id:");
        stringBuilder.append(realmGet$client_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{warehouse_id:");
        stringBuilder.append(realmGet$warehouse_id());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_syncupdate_AtheleteRealmProxy aAthelete = (com_syncupdate_AtheleteRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAthelete.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAthelete.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAthelete.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
