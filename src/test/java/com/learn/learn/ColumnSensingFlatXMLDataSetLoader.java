package com.learn.learn;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.core.io.Resource;

import java.io.InputStream;


public class ColumnSensingFlatXMLDataSetLoader extends AbstractDataSetLoader {
    /**
     * Crée la dataset.
     * @param resource an existing resource that contains the dataset data
     * @return IDataSet
     * @throws Exception
     */
    @Override
    protected IDataSet createDataSet(Resource resource) throws Exception {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        try (InputStream inputStream = resource.getInputStream()) {
            return createReplacementDataSet(builder.build(inputStream));
        }
    }

    /**
     * Remplace les colonnes avec valeur vide avec null
     * @param dataSet Contenu de la dataset
     * @return ReplacementDataSet Resultat de la dataset de remplacement
     */
    private ReplacementDataSet createReplacementDataSet(FlatXmlDataSet dataSet) {
        ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
        replacementDataSet.addReplacementObject("", null);
        return replacementDataSet;
    }
}