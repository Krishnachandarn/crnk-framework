package io.crnk.core.repository;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.resource.list.ResourceList;

import java.util.Collection;

/**
 * @deprecated in favor of OneRelationshipRepositoryBase and ManyRelationshipRepositoryBase.
 */
@Deprecated
public abstract class ReadOnlyRelationshipRepositoryBase<S, I, T, J>
        implements RelationshipRepository<S, I, T, J> {


    @Override
    public Class<S> getSourceResourceClass() {
        throw new UnsupportedOperationException("implement getMatcher() or this method");
    }

    @Override
    public Class<T> getTargetResourceClass() {
        throw new UnsupportedOperationException("implement getMatcher() or this method");
    }

    @Override
    public T findOneTarget(I sourceId, String fieldName, QuerySpec querySpec) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ResourceList<T> findManyTargets(I sourceId, String fieldName, QuerySpec querySpec) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRelation(S source, J targetId, String fieldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setRelations(S source, Collection<J> targetIds, String fieldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addRelations(S source, Collection<J> targetIds, String fieldName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeRelations(S source, Collection<J> targetIds, String fieldName) {
        throw new UnsupportedOperationException();
    }
}
