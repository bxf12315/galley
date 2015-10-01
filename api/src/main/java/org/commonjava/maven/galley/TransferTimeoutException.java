/**
 * Copyright (C) 2013 Red Hat, Inc. (jdcasey@commonjava.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.maven.galley;

import org.commonjava.maven.galley.model.ConcreteResource;
import org.commonjava.maven.galley.model.Location;
import org.commonjava.maven.galley.model.Transfer;
import org.commonjava.maven.galley.util.UrlUtils;

import java.net.MalformedURLException;

public class TransferTimeoutException
    extends TransferException
{

    private static final long serialVersionUID = 1L;

    private final Location location;

    private final String url;

    public TransferTimeoutException( final Location location, String url, final String format, final Object... params )
    {
        super( format, params );
        this.location = location;
        this.url = url;
    }

    public TransferTimeoutException( final Transfer target, final String format, final Object... params )
    {
        super( format, params );
        this.location = target.getLocation();
        String u;
        try
        {
            u = UrlUtils.buildUrl( target.getResource() );
        }
        catch ( MalformedURLException e )
        {
            u = target.getLocation().getUri() + target.getPath();
        }

        this.url = u;
    }

    public TransferTimeoutException( final ConcreteResource target, final String format, final Object... params )
    {
        super( format, params );
        this.location = target.getLocation();
        String u;
        try
        {
            u = UrlUtils.buildUrl( target );
        }
        catch ( MalformedURLException e )
        {
            u = target.getLocation().getUri() + target.getPath();
        }

        this.url = u;
    }

    public TransferTimeoutException( final Location location, final String url, final String format, final Throwable error, final Object... params )
    {
        super( format, error, params );
        this.location = location;
        this.url = url;
    }

    public Location getLocation()
    {
        return location;
    }

    public String getUrl()
    {
        return url;
    }

}
