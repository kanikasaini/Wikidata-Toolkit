package org.wikidata.wdtk.dumpfiles.constraint.renderer;

/*
 * #%L
 * Wikidata Toolkit RDF
 * %%
 * Copyright (C) 2014 Wikidata Toolkit Developers
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.wikidata.wdtk.datamodel.interfaces.PropertyIdValue;
import org.wikidata.wdtk.dumpfiles.constraint.format.Owl2FunctionalRendererFormat;
import org.wikidata.wdtk.dumpfiles.constraint.model.Constraint;

/**
 *
 * @author Julian Mendez
 *
 */
public class ConstraintUniqueValueObjectRendererTest implements
ConstraintRendererTestInterface {

	public static final String TEMPLATE_STR = "{{Constraint:Unique value}}";

	ConstraintRendererTestHelper testHelper = new ConstraintRendererTestHelper(
			"uniquevalueobject");

	public ConstraintUniqueValueObjectRendererTest() {
	}

	@Override
	public Constraint getConstraint() {
		return this.testHelper.getConstraint("P78",
				TEMPLATE_STR);
	}

	@Override
	@Test
	public void testRenderConstraint() throws IOException {
		ConstraintUniqueValueRenderer renderer = new ConstraintUniqueValueRenderer(
				new Owl2FunctionalRendererFormat(
						this.testHelper.getOutputStream()));
		renderer.render((PropertyIdValue) null);
		Assert.assertEquals("", this.testHelper.getOutputStream().toString());
		this.testHelper.testRenderConstraint(renderer, getConstraint());
	}

	@Override
	@Test
	public void testRdfRenderer() throws RDFParseException,
	RDFHandlerException, IOException {
		this.testHelper.testRdfRenderer(getConstraint());
	}

	@Override
	@Test
	public void testOwl2FunctionalRenderer() throws IOException {
		this.testHelper.testOwl2FunctionalRenderer(getConstraint());
	}

}
