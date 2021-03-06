/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicketstuff.jquery.cornerz;

import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.resources.CompressedResourceReference;
import org.wicketstuff.jquery.JQueryBehavior;

/**
 * 
 * @author Edvin Syse <edvin@sysedata.no>
 *
 */
public class CornerzBehaviour extends JQueryBehavior {
    public static final CompressedResourceReference CORNERZ_JS = new CompressedResourceReference(CornerzBehaviour.class, "jquery.cornerz.js");
    private CornerzOptions options_;
    
    public CornerzBehaviour() {
    	this(new CornerzOptions());
	}
    
    public CornerzBehaviour(CornerzOptions options) {
    	super();
    	options_ = options != null ? options : new CornerzOptions();
    }
    
    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.renderJavascriptReference(CORNERZ_JS);
    }

    @Override protected CharSequence getOnReadyScript() {
    	return "\t$('#" + getComponent().getMarkupId() + "').cornerz(" + options_.toString(false) + ");";
    }
}
