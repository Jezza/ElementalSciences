package me.jezzadabomb.es.core.handlers;

import me.jezzadabomb.es.core.helpers.LocalizationHelper;
import me.jezzadabomb.es.lib.Localizations;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
    public static void loadLanguages(){
        for(String LocationFile: Localizations.localeFiles){
            LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.getLocaleFromFileName(LocationFile), LocalizationHelper.isXMLLanguageFile(LocationFile));
        }
    }
}
