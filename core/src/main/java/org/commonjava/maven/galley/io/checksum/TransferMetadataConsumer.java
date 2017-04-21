package org.commonjava.maven.galley.io.checksum;

import org.commonjava.maven.galley.model.Transfer;

/**
 * Interface describing something that consumes checksum (and length) information about a stream).
 */
public interface TransferMetadataConsumer
{
    void accept( Transfer transfer, TransferMetadata transferData );
}